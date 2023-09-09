## Longest Nice Substring

**Problem Statement:**

A string `s` is considered nice if, for every letter of the alphabet that `s` contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not nice because 'b' appears, but 'B' does not.

Given a string `s`, you need to return the longest substring of `s` that is considered nice. If there are multiple such substrings, return the one that occurs earliest in the original string `s`. If there are no nice substrings, return an empty string.

**Examples:**

**Example 1:**

Input: `s = "YazaAay"`
Output: `"aAa"`
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in `s`, and both 'A' and 'a' appear. "aAa" is also the longest nice substring.

**Example 2:**

Input: `s = "Bb"`
Output: `"Bb"`
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.

**Example 3:**

Input: `s = "c"`
Output: `""`
Explanation: There are no nice substrings in the string `s`.

**Constraints:**

- 1 <= s.length <= 100
- `s` consists of uppercase and lowercase English letters.

## Solution:

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        if (n == 1) {
            return "";
        }

        Set<Character> charset = new HashSet<>();
        for (int i = 0; i < n; i++) {
            charset.add(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            if (charset.contains(Character.toLowerCase(s.charAt(i))) && charset.contains(Character.toUpperCase(s.charAt(i)))) {
                continue;
            }
            String prev = longestNiceSubstring(s.substring(0, i)); // create two substrings to compare length
            String next = longestNiceSubstring(s.substring(i + 1));
            return prev.length() >= next.length() ? prev : next; // return the substring of max length
        }

        return s;
    }
}

```

## Explanation:

```java


class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        if (n == 1) {
            return "";
        }

        Set<Character> charset = new HashSet<>();
        for (int i = 0; i < n; i++) {
            charset.add(s.charAt(i));
        }
```

1. The code begins by defining a class called `Solution` with a method `longestNiceSubstring` that takes a string `s` as input. This method is supposed to find the longest nice substring within the given string.

2. It calculates the length of the input string `s` and stores it in the variable `n`.

3. The code checks if the length of the input string is 1. If `n` is 1, it means there's only one character in the string, and by definition, there can't be a nice substring. Therefore, it returns an empty string `""`.

4. Next, the code creates a `Set` called `charset` to store unique characters encountered in the string. This set is used to keep track of the characters in the current substring being examined.

```java
        for (int i = 0; i < n; i++) {
            charset.add(s.charAt(i));
        }
```

5. It then iterates through the characters of the input string using a for loop. For each character at position `i`, it adds that character to the `charset` set using `charset.add(s.charAt(i))`. This set will now contain all unique characters present in the input string.

```java
        for (int i = 0; i < n; i++) {
            if (charset.contains(Character.toLowerCase(s.charAt(i))) && charset.contains(Character.toUpperCase(s.charAt(i)))) {
                continue;
            }

            String prev = longestNiceSubstring(s.substring(0, i)); // create two substrings to compare length
            String next = longestNiceSubstring(s.substring(i + 1));
            return prev.length() >= next.length() ? prev : next; // return the substring of max length
        }

        return s;
    }
}
```

6. After creating the `charset` set, the code enters another loop that iterates through the characters of the input string `s`. This loop is used to find the longest nice substring.

7. For each character at position `i`, it checks if both the lowercase and uppercase versions of that character exist in the `charset` set. If they both exist, it means the character is nice, and the code continues to the next character. If not, it proceeds to find the longest nice substring by recursively calling the `longestNiceSubstring` function on the substrings before and after the current character.

8. The code creates two substrings, `prev` and `next`, by calling `s.substring(0, i)` and `s.substring(i + 1)`, respectively. These substrings represent the portions of the input string before and after the current character `s.charAt(i)`.

9. The code then recursively calls `longestNiceSubstring` on `prev` and `next` to find the longest nice substrings in those substrings.

10. Finally, it compares the lengths of `prev` and `next` using `prev.length() >= next.length()` and returns the longer substring as the result. This ensures that the code returns the earliest occurring longest nice substring if there are multiple candidates.

11. If the loop completes without finding any nice substring, it means the entire input string is a nice substring, so it returns the input string `s`.

In summary, this Java code recursively searches for the longest nice substring within the input string `s` by checking each character and splitting the string into substrings to find the nicest substring. It returns the earliest occurring longest nice substring or the input string if there are no nice substrings.
