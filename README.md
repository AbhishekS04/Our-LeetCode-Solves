# 🚀 Our LeetCode Solutions

<div align="center">

![LeetCode](https://img.shields.io/badge/LeetCode-Solutions-orange?style=for-the-badge&logo=leetcode&logoColor=white)
![C++](https://img.shields.io/badge/C++-00599C?style=for-the-badge&logo=c%2B%2B&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Contributors](https://img.shields.io/badge/Contributors-4-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

</div>

## 📖 About This Repository

Welcome to our collaborative repository for LeetCode problem solutions! This is a team effort where we enhance our coding skills daily by solving random problems using **Java** and **C++**.

### 🎯 Mission Statement
To collaboratively solve and document various LeetCode problems, enhancing our coding skills and promoting knowledge sharing through daily practice.

### 🌟 Why This Repository?
- **Daily Practice**: Consistent problem-solving to build strong fundamentals
- **Collaborative Learning**: Different perspectives on the same problem
- **Code Quality Focus**: Clean, readable, and efficient solutions
- **Knowledge Sharing**: Learn from each other's approaches and techniques
- **Progress Tracking**: Monitor individual and collective growth
- **Cross-Language Learning**: Compare Java and C++ implementations
- **Documentation**: Maintain detailed explanations of algorithms and approaches
- **Random Problem Solving**: Tackle diverse problems to build versatility

## 📁 Repository Structure

```
Our-LeetCode-Solves/
├── AbhishekSingh/                    # Abhishek's C++ solutions
│   ├── Easy/                         # Easy difficulty problems
│   │   └── twoSum.cpp                # Example solution
│   ├── Medium/                       # Medium difficulty problems
│   │   └── twoSum.cpp                # Example solution
│   ├── Hard/                         # Hard difficulty problems
│   │   └── twoSum.cpp                # Example solution
│   └── Templates/                    # C++ code templates & utilities
├── SnehasishMondal/                  # Snehasish's C++ solutions
│   ├── Easy/
│   │   └── twoSum.cpp                # Example solution
│   ├── Medium/
│   │   └── twoSum.cpp                # Example solution
│   ├── Hard/
│   │   └── twoSum.cpp                # Example solution
│   └── Templates/
├── SayanMukharjee/                  # Sayan's C++ solutions
│   ├── Easy/
│   │   └── twoSum.cpp                # Example solution
│   ├── Medium/
│   │   └── twoSum.cpp                # Example solution
│   ├── Hard/
│   │   └── twoSum.cpp                # Example solution
│   └── Templates/
├── TusharKantiDey/                   # Tushar's Java solutions
│   ├── Easy/
│   │   └── twoSum.cpp                
│   ├── Medium/
│   │   └── twoSum.cpp                
│   ├── Hard/
│   │   └── twoSum.cpp                
│   └── Templates/
├── Docs/                             # Documentation & resources
│   └── docs.txt                      # Documentation file
├── .gitignore                        # Git ignore file
├── README.md                         # This file
└── LICENSE                           # MIT License
```

## 📊 Progress Tracking

We track our progress manually. To update the README with latest statistics, run:

```bash
python Scripts/update_readme.py
git add README.md
git commit -m "📊 Update progress statistics"
git push
```

## 👥 Contributors

| Contributor | Language | Joined | Status |
|-------------|----------|--------|---------|
| **Abhishek Singh** | C++ | 2025 | 🔥 Active |
| **Snehasish Mondal** | C++ | 2025 | 🔥 Active |
| **Sayan Mukharjee** | C++ | 2025 | 🔥 Active |
| **Tushar Kanti Dey** | Java | 2025 | 🔥 Active |

## 🎯 Our Approach

- **Random Daily Problems**: Each day we pick random problems to solve
- **No Specific Focus**: We tackle whatever interests us or challenges us
- **Cross-Language Comparison**: Java vs C++ implementations
- **Peer Review**: Learn from each other's coding styles
- **Consistent Practice**: Building habits through regular contributions

## 📋 Coding Standards

### For C++ Solutions (Abhishek , Snehasish & Sayan)
```cpp
// File naming: [ProblemNumber]_[ProblemName].cpp
// Example: 001_TwoSum.cpp

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // Brief description of the approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    vector<int> twoSum(vector<int>& nums, int target) {
        // Implementation here
    }
};

int main() {
    // Test cases
    Solution sol;
    // Add test examples
    return 0;
}
```

### For Java Solutions (Tushar)
```java
// File naming: [ProblemNumber]_[ProblemName].java
// Example: 001_TwoSum.java

import java.util.*;

public class Solution {
    /**
     * Brief description of the approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        // Implementation here
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test cases
    }
}
```

## 📝 Contribution Guidelines

### Before Starting
1. **Check existing solutions** to avoid duplicates
2. **Choose your difficulty level** (Easy → Medium → Hard)
3. **Create appropriate folder structure** if it doesn't exist

### Solution Format
Each solution should include:
- **Problem statement** (as a comment at the top)
- **Approach explanation** 
- **Time and Space complexity analysis**
- **Clean, readable code**
- **Test cases** in the main function

### Commit Message Format
```
[Language] Add/Update Problem: [Problem Name]

- Problem Number: #XXX
- Difficulty: Easy/Medium/Hard
- Approach: Brief description
```

Example:
```
[C++] Add Problem: Two Sum

- Problem Number: #001
- Difficulty: Easy
- Approach: Hash map for O(n) solution
```

## 🔥 Progress Tracking

### Current Statistics
- **Total Problems Solved**: `2`
- **Easy**: `2` | **Medium**: `0` | **Hard**: `0`

### Individual Progress
| Contributor | Easy | Medium | Hard | Total |
|-------------|------|--------|------|-------|
| Abhishek Singh | 2 | 0 | 0 | 2 |
| Snehasish Mondal | 0 | 0 | 0 | 0 |
| Tushar Kanti Dey | 0 | 0 | 0 | 0 |
| Sayan Mukharjee | 2 | 0 | 0 | 0 |

*Last Updated: [08-08-2025]*

## 🚀 Getting Started

### Prerequisites
- **For C++**: GCC compiler or any C++ IDE
- **For Java**: JDK 8+ and any Java IDE

### Setup Instructions
1. **Clone the repository**
   ```bash
   git clone https://github.com/AbhishekS04/Our-LeetCode-Solves.git
   cd Our-LeetCode-Solves
   ```

2. **Navigate to your folder**
   ```bash
   cd [YourName]/
   ```

3. **Create difficulty folders** (if not present)
   ```bash
   mkdir Easy Medium Hard
   ```

4. **Start coding!** 🎉

### Running Solutions

#### For C++:
```bash
g++ -o solution [ProblemNumber]_[ProblemName].cpp
./solution
```

#### For Java:
```bash
javac [ProblemNumber]_[ProblemName].java
java Solution
```

## 🏆 Milestones

- [ ] **First 10 Problems** - Getting warmed up
- [ ] **50 Problems** - Building momentum
- [ ] **100 Problems** - Strong foundation
- [ ] **200 Problems** - Advanced problem solver
- [ ] **300+ Problems** - LeetCode Champion! 🎉

## 📚 Resources

- [LeetCode](https://leetcode.com/) - Problem source
- [C++ Reference](https://cppreference.com/) - C++ documentation
- [Java Documentation](https://docs.oracle.com/en/java/) - Java official docs
- [Big O Cheat Sheet](https://www.bigocheatsheet.com/) - Complexity reference

## 🤝 How to Contribute

1. **Fork** this repository
2. **Create** a new branch for your solution
3. **Add** your solution following the guidelines
4. **Commit** with proper message format
5. **Push** to your branch
6. **Create** a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🎉 Let's Code Together!

Remember: *"The best way to learn is by doing, and the best way to do is together!"*

Happy Coding! 💻✨

---

**Note**: Keep this README updated as we progress. Update the statistics table regularly to track our collective growth!
