impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut map = [0; 26];
        let mut ans = s.len();
        for c in s.chars() {
            map[c as usize - 'A' as usize] += 1;
        }
        let mut i = 0;
        for (j, c) in s.chars().enumerate() {
            map[c as usize - 'A' as usize] -= 1;
            while i < s.len() && map['Q' as usize - 'A' as usize] <= s.len() / 4 && map['W' as usize - 'A' as usize] <= s.len() / 4 && map['E' as usize - 'A' as usize] <= s.len() / 4 && map['R' as usize - 'A' as usize] <= s.len() / 4 {
                ans = ans.min(j - i + 1);
                map[s.chars().nth(i).unwrap() as usize - 'A' as usize] += 1;
                i += 1;
            }
        }
        ans as i32
    }
}