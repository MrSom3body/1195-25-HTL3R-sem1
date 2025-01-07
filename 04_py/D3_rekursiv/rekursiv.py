from time import time


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
    t_start = time()
    m_list = [M(i) for i in range(1, 201)]
    m_dict = {i: M(i) for i in range(1, 201)}
    t_end = time()
    print(f"Time elapsed: {t_end - t_start:.6f}s")
    # takes 0.000736s on my machine
