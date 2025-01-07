def collatz(n: int) -> int:
    """
    :param n: non-negative integer
    """
    if n % 2 == 0:
        return int(n / 2)
    else:
        return 3 * n + 1


if __name__ == "__main__":
    assert collatz(1) == 4
    assert collatz(5) == 16
    assert collatz(8) == 4
