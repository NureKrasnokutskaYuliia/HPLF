#import "@local/nure:0.1.1": pz-lb, style.appendices, style.spacing

#show: pz-lb.with(
  title: "Основи Python та робота з даними",
  subject: "ВМПтФ",
  layout: "ХНУРЕ",
  type: "ПЗ",
  number: 1,
  edu-program: "ПЗПІ",
  university: "ХНУРЕ",
  mentors: (
    (
      name: "Саманцов О. О.",
      degree: "ст. викл. кафедри ПІ",
      gender: "m",
    ),
  ),
  authors: (
    (
      name: "Краснокутська Ю. Є.",
      edu-program: "ПЗПІ",
      group: "23-2",
      gender: "f",
      variant: 8,
    ),
  ),
)

#v(-spacing)
== Мета роботи
Метою даної роботи є ознайомлення з базовими можливостями мови Python. Розгляд
базових лінійних конструкції, розгалужень, циклів, функцій, створення та
використання класів.

== Індивідуальне завдання
- Рівень 1: Напишіть функцію, яка приймає три параметри (a, b, c) і виводить на
  екран найменше з них.
- Рівень 2: Напишіть функцію, яка приймає рядок та повертає його обернений
  варіант. Наприклад, "hello" повинно повернути "olleh".
- Рівень 3: Реалізуйте програму, яка визначає, чи є слово паліндромом
  (читається однаково з обох боків).
- Рівень 4: Реалізуйте програму, яка визначає, чи є слово паліндромом
  (читається однаково з обох боків).

== Хід роботи
=== Рівень 1
```python
def print_min1(a, b, c):
    print(min(a, b, c))

def print_min2(a, b, c):
    if a <= b and a <= c:
        print(a)
    elif b <= a and b <= c:
        print(b)
    else:
        print(c)
```

=== Рівень 2
```python
def reverse_string(s):
    return s[::-1]
```

=== Рівень 3
```python
def is_palindrome(word):
    return word == word[::-1]
```

=== Рівень 4
```python
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)
```

=== Код перевірки роботи розроблених функцій
```python
if __name__ == "__main__":
    print_min1(10, 5, 8) # => 5
    print_min2(10, 5, 8) # => 5

    print(reverse_string('hello')) # => olleh
    print(reverse_string('boy')) # => yob

    print(is_palindrome('radar')) # => True
    print(is_palindrome('python')) # => False
    print(is_palindrome('level')) # => True

    arr = [5, 2, 9, 1, 5, 6]
    print(quicksort(arr)) => [1, 2, 5, 5, 6, 9]
```
== Висновки
Під час виконання даної роботи було розглянуто базові лінійні конструкції,
розгалуження, цикли, функції, створення та використання класів.
