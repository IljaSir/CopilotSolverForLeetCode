impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut ret = Vec::new();
        let mut tmp = String::new();
        let mut map = HashMap::new();
        map.insert('2', vec!['a', 'b', 'c']);
        map.insert('3', vec!['d', 'e', 'f']);
        map.insert('4', vec!['g', 'h', 'i']);
        map.insert('5', vec!['j', 'k', 'l']);
        map.insert('6', vec!['m', 'n', 'o']);
        map.insert('7', vec!['p', 'q', 'r', 's']);
        map.insert('8', vec!['t', 'u', 'v']);
        map.insert('9', vec!['w', 'x', 'y', 'z']);
        if digits.is_empty() {
            return ret;
        }
        Solution::dfs(&digits, 0, &mut tmp, &mut ret, &mut map);
        ret
    }
    fn dfs(digits: &String, idx: usize, tmp: &mut String, ret: &mut Vec<String>, map: &mut HashMap<char, Vec<char>>) {
        if idx == digits.len() {
            ret.push(tmp.clone());
            return;
        }
        for c in map.get(&digits.chars().nth(idx).unwrap()).unwrap() {
            tmp.push(*c);
            Solution::dfs(digits, idx + 1, tmp, ret, map);
            tmp.pop();
        }
    }
}