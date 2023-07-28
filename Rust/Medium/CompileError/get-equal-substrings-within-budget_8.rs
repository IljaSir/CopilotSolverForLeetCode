impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let mut cost = 0;
        let mut ans = 0;
        let mut left = 0;
        let mut right = 0;
        let mut cost_vec = vec![];
        for (a, b) in s.chars().zip(t.chars()) {
            let c = (a as u32 - b as u32).abs();
            cost_vec.push(c);
        }
        while right < cost_vec.len() {
            cost += cost_vec[right];
            while cost > max_cost {
                cost -= cost_vec[left];
                left += 1;
            }
            ans = ans.max(right - left + 1);
            right += 1;
        }
        ans as i32
    }
}