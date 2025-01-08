def collatz(n: int) -> int:
    """
    :param n: non-negative integer
    :return: the next number in the collatz sequence
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
    """
    :param number: Startzahl
    :return: Startwert und Länge der längsten Collatz Zahlenfolge deren Startwert <=n ist

    >>> longest_collatz_sequence(100)
    (97, 119)
    """
    max_cl = (0, 0)
    for i in range(n, 0, -1):
        cl = collatz_sequence(i)
        if len(cl) > max_cl[1]:
            max_cl = (i, len(cl))

    return max_cl


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
