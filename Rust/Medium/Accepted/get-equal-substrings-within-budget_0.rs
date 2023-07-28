impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let s: Vec<i32> = s.chars().map(|c| c as i32).collect();
        let t: Vec<i32> = t.chars().map(|c| c as i32).collect();
        let mut cost = 0;
        let mut ans = 0;
        let mut begin = 0;
        for i in 0..s.len() {
            cost += (s[i] - t[i]).abs();
            while cost > max_cost {
                cost -= (s[begin] - t[begin]).abs();
                begin += 1;
            }
            ans = ans.max(i - begin + 1);
        }
        ans as i32
    }
}