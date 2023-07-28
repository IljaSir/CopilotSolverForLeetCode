impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut ans = binary.clone();
        let mut cnt = 0;
        let mut start = 0;
        let mut end = 0;
        for (i, c) in binary.chars().enumerate() {
            if c == '0' {
                if cnt == 0 {
                    start = i;
                }
                cnt += 1;
                end = i;
            }
        }
        if cnt == 0 {
            return ans;
        }
        for i in start..=end {
            ans.remove(i);
            ans.insert(i, '1');
        }
        ans
    }
}