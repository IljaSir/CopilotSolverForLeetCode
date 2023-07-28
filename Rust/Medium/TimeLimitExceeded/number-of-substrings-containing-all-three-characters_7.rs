impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut nums = vec![0; 3];
        let mut start = 0;
        let mut ans = 0;
        let mut count = 0;
        for (i, c) in s.chars().enumerate() {
            nums[c as usize - 'a' as usize] += 1;
            if nums[c as usize - 'a' as usize] == 1 {
                count += 1;
            }
            while count == 3 {
                nums[s.chars().nth(start).unwrap() as usize - 'a' as usize] -= 1;
                if nums[s.chars().nth(start).unwrap() as usize - 'a' as usize] == 0 {
                    count -= 1;
                }
                start += 1;
            }
            ans += start;
        }
        ans as i32
    }
}