impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut ret: Vec<String> = Vec::new();
        if digits.len() == 0 {
            return ret;
        }
        let mut map: HashMap<char, Vec<char>> = HashMap::new();
        map.insert('2', vec!['a', 'b', 'c']);
        map.insert('3', vec!['d', 'e', 'f']);
        map.insert('4', vec!['g', 'h', 'i']);
        map.insert('5', vec!['j', 'k', 'l']);
        map.insert('6', vec!['m', 'n', 'o']);
        map.insert('7', vec!['p', 'q', 'r', 's']);
        map.insert('8', vec!['t', 'u', 'v']);
        map.insert('9', vec!['w', 'x', 'y', 'z']);
        let mut stack: Vec<String> = Vec::new();
        stack.push(String::new());
        for c in digits.chars() {
            let mut tmp: Vec<String> = Vec::new();
            for s in stack {
                for &x in map.get(&c).unwrap() {
                    tmp.push(format!("{}{}", s, x));
                }
            }
            stack = tmp;
        }
        ret = stack;
        ret
    }
}