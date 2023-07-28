impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let v1 = version1.split('.').map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let v2 = version2.split('.').map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let max_len = std::cmp::max(v1.len(), v2.len());
        for i in 0..max_len {
            let v1_i = if i < v1.len() { v1[i] } else { 0 };
            let v2_i = if i < v2.len() { v2[i] } else { 0 };
            if v1_i > v2_i {
                return 1;
            } else if v1_i < v2_i {
                return -1;
            }
        }
        0
    }
}