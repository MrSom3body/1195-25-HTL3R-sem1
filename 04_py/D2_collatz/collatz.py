def collatz(n: int) -> int:
    """
    :param n: non-negative integer
    """
    if n % 2 == 0:
        return int(n / 2)
    else:
        return 3 * n + 1


def collatz_sequence(number: int) -> list[int]:
    return []


if __name__ == "__main__":
    assert collatz(1) == 4
    assert collatz(5) == 16
    assert collatz(8) == 4

    assert collatz_sequence(14) == [
        14,
        7,
        22,
        11,
        34,
        17,
        52,
        26,
        13,
        40,
        20,
        10,
        5,
        16,
        8,
        4,
        2,
        1,
    ]
    assert collatz_sequence(7) == [
        7,
        22,
        11,
        34,
        17,
        52,
        26,
        13,
        40,
        20,
        10,
        5,
        16,
        8,
        4,
        2,
        1,
    ]
