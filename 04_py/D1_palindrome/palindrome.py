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


def is_palindrome_sentence(s: str) -> bool:
    """
    :param s: string of a sentence to check if it is a palindrom
    :return: True if s is a palindrom, False otherwise
    """
    filtered = ""
    for ch in s:
        if ch.isalnum():
            filtered += ch

    return is_palindrome(filtered.lower())


def palindrome_product(x: int) -> int:
    return 0


if __name__ == "__main__":
    print("Expected: True, Actual:", is_palindrome("anna"))
    print("Expected: False, Actual:", is_palindrome("hello"))
    print("Expected: True, Actual:", is_palindrome("racecar"))

    print(
        "Expected: True, Actual:",
        is_palindrome_sentence("Was it a car or a cat I saw?"),
    )
    print(
        "Expected: False, Actual:",
        is_palindrome_sentence("This is not a palindrome."),
    )
    print(
        "Expected: True, Actual:",
        is_palindrome_sentence("A man, a plan, a canal, Panama!"),
    )

    print("Expected: 906609, Actual:", palindrome_product(1000000))  # 913 x 993
    print("Expected: 793397, Actual:", palindrome_product(800000))  # 869 x 913
    print("Expected: 595595, Actual:", palindrome_product(600000))  # 935 x 637
