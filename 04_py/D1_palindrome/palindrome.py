__author__ = "Karun Sandhu"


def is_palindrome(s: str) -> bool:
    """
    :param s: string to check if it is a palindrom
    :return: True if s is a palindrom, False otherwise
    """
    reverse = ""
    for ch in reversed(s):
        reverse += ch

    return s == reverse


if __name__ == "__main__":
    print("Expected: True, Actual:", is_palindrome("anna"))
    print("Expected: False, Actual:", is_palindrome("hello"))
    print("Expected: True, Actual:", is_palindrome("racecar"))
