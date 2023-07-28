impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        let mut v = nums;
        v.sort();
        let mut i = 0;
        while i < v.len() {
            if v[i] == 0 {
                i += 1;
                continue;
            }
            let mut j = i + 1;
            let mut count = 1;
            let mut last = v[i];
            v[i] = 0;
            while count < k as usize {
                if j >= v.len() {
                    return false;
                }
                if v[j] == 0 {
                    j += 1;
                    continue;
                }
                if v[j] == last + 1 {
                    v[j] = 0;
                    last = v[j];
                    count += 1;
                    j += 1;
                } else if v[j] > last + 1 {
                    return false;
                } else {
                    j += 1;
                }
            }
            i += 1;
        }
        true
    }
}