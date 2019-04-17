# Enter your code here. Read input from STDIN. Print output to STDOUT
import collections

N = int(input())

deque = collections.deque()

for i in range(0, N):
    cmd = input().split(' ')

    method = cmd[0]
    if len(cmd) > 1:
        value = cmd[1]

    if method == "append":
        deque.append(value)

    elif method == "appendleft":
        deque.appendleft(value)

    elif method == "pop":
        deque.pop()

    elif method == "popleft":
        deque.popleft()

    else:
        print("tough titties", method)

for v in deque:
    print(v, end=" ")
