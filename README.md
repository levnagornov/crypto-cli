<div align="center">
    <h1>Crypto CLI</h1>
    <img src="https://i.ibb.co/xh8rP5x/java-logo-icon-168609.png" width="128" alt="API">
</div>

[![license](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

## Description

This СLI app works with the Caesar cipher. This is one of the simplest and most famous encryption methods.

🛠️ Program functionality:
- Text encryption using a specific key
- Text encryption using a random key
- Decrypting text using a specific key
- Decrypting text using brute force (searching through all options)
- (not yet implemented) Decrypting text using statistical text analysis

So, the program opens a text file specified by the user and performs one of the above actions with it, then a new file with the result is created in the same directory.

✨ Other features:
- SOLID principles usage
- Design patterns usage: Factory, Command, Template method, Singleton
- Unit testing

Created by Lev Nagornov.

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Install

1. Clone the repository using:

    ```
    git clone git@github.com:levnagornov/crypto-cli.git
    ```

2. Install Java if needed:
   ```
   sudo apt update
   sudo apt install default-jdk
   java -version
    ```
   
3. Download and install [Maven](https://maven.apache.org/download.cgi)

4. Build the project
   ```
   cd crypto-cli
   mvn package
    ```
   
5. Run the app
   ```
   java -jar target/crypto-cli-1.0-SNAPSHOT.jar
    ```

## Usage

1. Start the app.
2. Select options by typing number and hit enter to confirm
3. Provide an encrypted file
4. Check result


<img src="demo/crypto-cli-demo-1.png" width="512" alt="demo-1">
<br>
<img src="demo/crypto-cli-demo-2.png" width="512" alt="demo-1">


## Contributing

PRs accepted.

Small note: If editing the Readme, please conform to the [standard-readme](https://github.com/RichardLitt/standard-readme) specification.

## License

[MIT © Lev Nagornov.](./LICENSE)
