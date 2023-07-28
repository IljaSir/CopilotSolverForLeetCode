impl Solution {
    pub fn find_array(pref: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut prev = 0;
        for i in 0..pref.len() {
            let cur = prev ^ pref[i];
            res.push(cur);
            prev = cur;
        }
        res
    }
}