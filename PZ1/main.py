def print_min1(a, b, c):
    print(min(a, b, c))
    
def print_min2(a, b, c):
    if a <= b and a <= c:
        print(a)
    elif b <= a and b <= c:
        print(b)
    else:
        print(c)

def reverse_string(s):
    return s[::-1]

def is_palindrome(word):
    return word == word[::-1]

def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)

if __name__ == "__main__":
    print_min1(10, 5, 8) 
    print_min2(10, 5, 8)

    print(reverse_string('hello'))
    print(reverse_string('boy'))

    print(is_palindrome('radar'))
    print(is_palindrome('python'))
    print(is_palindrome('level'))

    arr = [5, 2, 9, 1, 5, 6]
    print(quicksort(arr))
