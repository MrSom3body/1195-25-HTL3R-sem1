def collatz(n: int) -> int:
    """
    :param n: non-negative integer
    """
    if n % 2 == 0:
        return int(n / 2)
    else:
        return 3 * n + 1


def collatz_sequence(number: int) -> list[int]:
    """
    :param number: Startzahl
    :return: Collatz Zahlenfolge, resultierend aus n
    >>> collatz_sequence(19)
    [19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1]
    """
    cl: list[int] = [number]
    while cl[-1] != 1:
        cl.append(collatz(cl[-1]))

    return cl


def longest_collatz_sequence(n: int) -> tuple[int, int]:
    return (0, 0)


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

    assert longest_collatz_sequence(100) == (97, 119)
    assert longest_collatz_sequence(69) == (55, 113)
