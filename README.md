# CEToolBox

CEToolBox is a program featuring tools made for Capital Energy Services
>#### PPL ECL Tool
> Parses a PPL ECL, providing organized information and automatically downloading account Monthly Usage from the PPL Supplier Portal
> 
>
> - Selenium
> - Apache POI

>#### SFE Margin Calculator
> Calculates broker fee given the broker & supplier rates and utility tax of the state

## Requirements
- Java 11
- Tested on Windows
- Internet Connection

## Installation

Extract _CEToolBox-v1.0.zip_ and its contents

>Manually through File Explorer or archiver software (7zip, WinRAR, etc.)

## Usage

### Prerequisites
>#### PPL ECL Tool
- Enter PPL Supplier Portal login information in _PPL_Login.csv_ on the 2nd row 
    - If using Excel: cells A2, B2  →  username, password
    - If using text editor: 2nd line  →  username, password
- Populate _ECL_PPL.xlsx_ with entries starting from the 2nd row
>#### SFE Margin Calculator
- No prerequisites

###  Commands
```
1: ECL PPL Tool
2: SFE Margin Calculator
q: Quit
h: Show all commands
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.


## License

[MIT](https://choosealicense.com/licenses/mit/)