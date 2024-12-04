import java.util.*;

// In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:
//
//     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
//
// It is possible to make £2 in the following way:
//
//     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
//
// How many different ways can £2 be made using any number of coins?

class Main {
  public static void main(String[] args) {
    int goal = 200;
    long iterations = 0;
    int count = 0;

    for (int a = 0; a <= goal; a++) {
      for (int b = 0; b <= goal; b += 2) {
        for (int c = 0; c <= goal; c += 5) {
          for (int d = 0; d <= goal; d += 10) {
            for (int e = 0; e <= goal; e += 20) {
              for (int f = 0; f <= goal; f += 50) {
                for (int g = 0; g <= goal; g += 100) {
                  for (int h = 0; h <= goal; h += 200) {
                    // 5768123130 total iterations (201 * 101 * 41 * 21 * 11 * 5 * 3 * 2)
                    iterations++;
                    if (a + b + c + d + e + f + g + h == goal) {
                      count += 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    System.out.println(count);
    System.out.println(iterations);
  }
}
