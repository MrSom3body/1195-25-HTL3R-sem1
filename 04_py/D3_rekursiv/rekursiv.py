def M(n: int) -> int:
    """
    :param n: the input integer to run through the McCarthy-91 function
    :return: the computed result
    """
    if n <= 100:
        return M(M(n + 11))
    else:
        return n - 10


if __name__ == "__main__":
    # The McCarthy-91 function is special because every input from 0-101 will return 91
    m_list = [M(i) for i in range(1, 201)]
    print(m_list)
