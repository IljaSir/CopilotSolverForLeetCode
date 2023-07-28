impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut ans = Vec::new();
        let mut stack = Vec::new();
        let mut cur = String::new();
        let mut idx = 0;
        let mut map = HashMap::new();
        map.insert('2', String::from("abc"));
        map.insert('3', String::from("def"));
        map.insert('4', String::from("ghi"));
        map.insert('5', String::from("jkl"));
        map.insert('6', String::from("mno"));
        map.insert('7', String::from("pqrs"));
        map.insert('8', String::from("tuv"));
        map.insert('9', String::from("wxyz"));
        if digits.len() == 0 {
            return ans;
        }
        stack.push((idx, cur));
        while stack.len() > 0 {
            let (i, s) = stack.pop().unwrap();
            if i == digits.len() {
                ans.push(s);
                continue;
            }
            let letters = map.get(&digits.chars().nth(i).unwrap()).unwrap();
            for c in letters.chars() {
                stack.push((i + 1, s.clone() + &c.to_string()));
            }
        }
        ans
    }
}