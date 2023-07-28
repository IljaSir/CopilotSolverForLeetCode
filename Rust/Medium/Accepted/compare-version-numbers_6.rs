impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let v1: Vec<&str> = version1.split('.').collect();
        let v2: Vec<&str> = version2.split('.').collect();
        let n = v1.len().max(v2.len());
        for i in 0..n {
            let a = if i < v1.len() {
                v1[i].parse::<i32>().unwrap()
            } else {
                0
            };
            let b = if i < v2.len() {
                v2[i].parse::<i32>().unwrap()
            } else {
                0
            };
            if a < b {
                return -1;
            } else if a > b {
                return 1;
            }
        }
        0
    }
}