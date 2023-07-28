impl Solution {
    pub fn interval_intersection(first_list: Vec<Vec<i32>>, second_list: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while i < first_list.len() && j < second_list.len() {
            let f = &first_list[i];
            let s = &second_list[j];
            if f[0] <= s[1] && s[0] <= f[1] {
                res.push(vec![f[0].max(s[0]), f[1].min(s[1])]);
            }
            if f[1] < s[1] {
                i += 1;
            } else {
                j += 1;
            }
        }
        res
    }
}