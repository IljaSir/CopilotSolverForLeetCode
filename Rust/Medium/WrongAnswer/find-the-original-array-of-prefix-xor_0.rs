impl Solution {
    pub fn find_array(pref: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![0; pref.len()];
        ans[0] = pref[0];
        for i in 1..pref.len() {
            ans[i] = ans[i-1] ^ pref[i];
        }
        ans
    }
}