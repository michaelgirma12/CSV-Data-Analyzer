
# CSV Data Analyzer

This project is a Java-based **data analysis tool** that processes and compares data from CSV files. It includes custom comparators, a graphical user interface (GUI), and a doubly linked list (DLList) for efficient data management.

## Features
- **Custom Comparators**: Sort and analyze data based on channel names, reach, and other metrics.
- **GUI Integration**: A user-friendly graphical interface for data visualization.
- **CSV Input**: Processes data input from sample CSV files.
- **Efficient Data Management**: Utilizes a doubly linked list (DLList) for storing and managing data.

## File Structure
- **`src/prj5`**:
   - `Account.java`: Represents accounts and related data.
   - `CompareByChannelName.java`, `CompareByReach.java`, `CompareByTrad.java`: Custom comparator classes.
   - `DataReader.java`: Reads and processes CSV input files.
   - `GUI.java`: The graphical interface for data visualization.
   - `DLList.java`: A doubly linked list implementation for managing data.
   - `MonthData.java`: Represents monthly data for accounts.
- **Sample CSV Files**:
   - `SampleInput1_2022.csv`
   - `SampleInput2_2022.csv`
   - `SampleInput3_2022.csv`
   - `SampleInput4_2022.csv`

## How to Run
1. **Compile the Project**:
   ```bash
   javac src/prj5/*.java
   ```
2. **Run the GUI**:
   ```bash
   java src/prj5.GUI
   ```

## Sample Input
Sample CSV files are provided for testing. Replace or modify these files as needed to test additional cases.

## License
This project is licensed under the MIT License.

## Authors
- Michael Girma  
- Maria Sherer  
- Ved Soolgiri  
