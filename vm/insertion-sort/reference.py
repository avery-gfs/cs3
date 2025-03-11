l = [3, 1, 4, 1, 5, 9, 2, 6, 5, 4]

for i in range(10):
    for j in range(i, 10):
        if l[j] < l[i]:
            tmp = l[i]
            l[i] = l[j]
            l[j] = tmp

print(l)
