import re
import sys
from reader import runApp

address_pattern = r'\b\w+\b(?:\s+\w+\b)*'
GOOGLE_ADDRESS_SEPARATOR = "%20"
def getAddress():
    print("Enter address in the format: Street Name, City and State(Two letters)")
    address = input("Enter the address separated by spaces and no special characters: ")
    if bool(re.fullmatch(address_pattern, address)):
        query_address = address.replace(" ", GOOGLE_ADDRESS_SEPARATOR)
        print(query_address)
        runApp(query_address)
    else: 
        print("Enter valid address.")
        response = input("Do you want to continue?")    
        if response in ("yes", "y", "ye", "Y", "Yes", "YES", "YES"):
            getAddress()
        else: 
            print("quitting...")
            sys.exit()