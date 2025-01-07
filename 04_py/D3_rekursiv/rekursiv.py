def M(n: int) -> int:
    """
    :param n: the input integer to run through the McCarthy-91 function
    :return: the computed result
    """
    if n <= 100:
        return M(M(n + 11))
    else:
        return n - 10
