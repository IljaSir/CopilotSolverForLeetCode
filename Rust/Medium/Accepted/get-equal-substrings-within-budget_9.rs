impl Solution {
    pub fn equal_substring(s: String, t: String, max_cost: i32) -> i32 {
        
        let mut sum = 0;
        let mut l = 0;
        let mut r = 0;
        let mut res = 0;
        let mut arr = vec![0; s.len()];
        for (i, (a, b)) in s.chars().zip(t.chars()).enumerate() {
            arr[i] = (a as i32 - b as i32).abs();
        }
        while r < s.len() {
            sum += arr[r];
            while sum > max_cost {
                sum -= arr[l];
                l += 1;
            }
            res = res.max(r - l + 1);
            r += 1;
        }
        res as i32
    }
}