import java.util.*;
import java.nio.file.*;

class Main {
    public static void main(String[] args) throws Exception {
        new VM().run("factorial/solution.txt");
    }
}

class VM {
    // Index of current instruction
    int ip = 0;
    // Last memory index read/written (for log)
    int lastMem = -1;
    // Output from program (store in string for TUI)
    String output = "";
    // Was a halt requested
    boolean halted;
    // Count total instructions evaluated
    int steps;

    // Instructions get populated by run method
    List<String> instrs = new ArrayList<>();
    // Registers initialized to zero
    List<Integer> registers = new ArrayList<>(List.of(0, 0, 0, 0));
    // Instructions get initialized by mem command
    int[] memory = {};

    void run(String path) throws Exception {
        // Load instructions from source file
        loadInsts(path);

        halted = false;
        steps = 0;

        while (!halted) {
            steps++;
            // Clear screen
            System.out.print("\033c");

            logInsts();
            System.out.println();
            logSteps();

            // Run instruction before doing rest of logging so that logs
            // reflect the VM state after running the current instruction
            runInst(instrs.get(ip));

            System.out.println();
            logRegs();
            System.out.println();
            logMem();
            System.out.println();
            logOutput();

            // Pause to visualize execution
            Thread.sleep(100);
        }
    }

    void loadInsts(String path) throws Exception {
        // Requires throws annotation
        List<String> lines = Files.readAllLines(Path.of(path));

        for (var line : lines) {
            line = line.trim();

            // Ignore empty source lines and comment lines
            if (!line.isEmpty() && !line.startsWith("--")) {
                instrs.add(line);
            }
        }
    }

    int regIndex(String regName) {
        if (!regName.startsWith("r")) {
            throw new Error("Invalid register name " + regName);
        }

        // Skip leading 'r' and parse number to integer
        return Integer.parseInt(regName.substring(1));
    }

    int[] evalArgs(String[] tokens) {
        // Resolve instruction argument, loading values
        // from registers and parsing constants to numbers
        var args = new int[tokens.length - 1];

        for (var index = 1; index < tokens.length; index++) {
            var token = tokens[index];

            args[index - 1] = token.startsWith("r")
              ? registers.get(regIndex(token))
              : Integer.parseInt(token);
        }

        return args;
    }

    void setReg(String regName, int value) {
        registers.set(regIndex(regName), value);
    }

    void runInst(String inst) {
        var tokens = inst.split("\\s+");
        var op = tokens[0];
        var args = evalArgs(tokens);

        switch (op) {
            case "add":
            case "sub":
            case "mul":
            case "div":
            case "mod":
            case "eq":
            case "gt":
            case "lt":
            case "and":
            case "or":
                setReg(tokens[1], binOp(op, args[0], args[1]));
                ip++;
                return;
            case "not":
                setReg(tokens[1], args[0] == 0 ? 1 : 0);
                ip++;
                return;
            case "set":
                setReg(tokens[1], args[1]);
                ip++;
                return;
            case "jmp":
                ip += args[0];
                return;
            case "jeq":
                ip += args[1] == args[2] ? args[0] : 1;
                return;
            case "jne":
                ip += args[1] != args[2] ? args[0] : 1;
                return;
            case "halt":
                halted = true;
                return;
            case "init":
                memory = args;
                ip++;
                return;
            case "load":
                setReg(tokens[1], memory[args[1]]);
                lastMem = args[1];
                ip++;
                return;
            case "store":
                memory[args[1]] = args[0];
                lastMem = args[0];
                ip++;
                return;
            case "log":
                if (!output.isEmpty()) {
                    output += "\n";
                }

                output += args[0];
                ip++;
                return;
            case "print":
                output += (char)args[0];
                ip++;
                return;
        }

        throw new Error("Invalid instruction " + op);
    }

    int binOp(String op, int a, int b) {
        switch (op) {
            case "add": return a + b;
            case "sub": return a - b;
            case "mul": return a * b;
            case "div": return a / b;
            case "mod": return a % b;
            case "eq":  return a == b ? 1 : 0;
            case "gt":  return a > b ? 1 : 0;
            case "lt":  return a < b ? 1 : 0;
            case "and": return a == 0 || b == 0 ? 0 : 1;
            case "or":  return a == 1 || b == 1 ? 1 : 0;
        }

        throw new Error("Unreachable");
    }

    void logInsts() {
        int index = 0;
        for (var inst : instrs) {
            System.out.print(ip == index ? "> " : "  ");
            System.out.println(inst);
            index++;
        }
    }

    void logSteps() {
        System.out.println("steps: " + steps);
    }

    void logRegs() {
        int index = 0;
        for (var reg : registers) {
            System.out.println("r" + index + ": " + reg);
            index++;
        }
    }

    void logMem() {
        System.out.print("memory: [");

        int index = 0;
        for (var n : memory) {
            System.out.print(index == lastMem ? "*" : " ");
            System.out.print(n);

            index++;
            if (index < memory.length) {
                System.out.print(", ");
            }

        }

        System.out.println(" ]");
    }

    void logOutput() {
        System.out.print(output);

        if (halted) {
            System.out.println();
        }
    }
}
