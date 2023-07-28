impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut nums = Vec::new();
        let mut i = 0;
        let mut d = s.len() as i32;
        for c in s.chars() {
            if c == 'I' {
                nums.push(i);
                i += 1;
            } else {
                nums.push(d);
                d -= 1;
            }
        }
        nums.push(i);
        nums
    }
}