impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut cnt = 0;
        let mut ans = String::new();
        let mut s = binary.chars().collect::<Vec<char>>();
        for i in 0..s.len() {
            if s[i] == '0' {
                cnt += 1;
            }
        }
        for i in 0..cnt {
            ans.push('1');
        }
        for i in cnt..s.len() {
            ans.push('0');
        }
        ans
    }
}