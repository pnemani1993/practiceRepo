#!/usr/bin/env python
import sys
from prompts import getAddress

def main() -> int:
    """Echo the beginning prompt to standard output"""
    # phrase = shlex.join(sys.argv)
    print("#"*20)
    value = input("Do you want weather forecast?")
    if value in ("yes", "y", "ye", "Y", "Yes", "YES", "YES"):
        getAddress()
        main()
    return 0

if __name__ == '__main__':
    sys.exit(main()) 
