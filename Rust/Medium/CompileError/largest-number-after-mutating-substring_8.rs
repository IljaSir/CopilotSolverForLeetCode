impl Solution {
    pub fn maximum_number(num: String, change: Vec<i32>) -> String {
        
        let mut ans = num.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 0;
        while j < ans.len() {
            if ans[j] as i32 - '0' as i32 < change[ans[j] as i32 - '0' as i32] {
                i = j;
                while j < ans.len() && ans[j] as i32 - '0' as i32 <= change[ans[j] as i32 - '0' as i32] {
                    ans[j] = (change[ans[j] as i32 - '0' as i32] + '0' as i32) as u8 as char;
                    j += 1;
                }
            } else {
                j += 1;
            }
        }
        ans.into_iter().collect()
    }
}