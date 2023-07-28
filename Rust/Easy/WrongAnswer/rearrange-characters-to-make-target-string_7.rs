impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut count = [0; 26];
        let mut freq = [0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        for c in target.chars() {
            freq[c as usize - 'a' as usize] += 1;
        }
        let mut ans = 0;
        let mut flag = true;
        while flag {
            flag = false;
            for i in 0..26 {
                if freq[i] > 0 && count[i] > 0 {
                    freq[i] -= 1;
                    count[i] -= 1;
                    flag = true;
                }
            }
            if flag { ans += 1; }
        }
        for i in 0..26 {
            if freq[i] > 0 { return 0; }
        }
        ans
    }
}