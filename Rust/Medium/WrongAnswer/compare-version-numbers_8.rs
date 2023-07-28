impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let v1: Vec<&str> = version1.split(".").collect();
        let v2: Vec<&str> = version2.split(".").collect();
        let mut v1_iter = v1.iter();
        let mut v2_iter = v2.iter();
        loop {
            let v1_i = v1_iter
                .next()
                .map(|v| v.parse::<i32>().unwrap_or(0))
                .unwrap_or(0);
            let v2_i = v2_iter
                .next()
                .map(|v| v.parse::<i32>().unwrap_or(0))
                .unwrap_or(0);
            if v1_i > v2_i {
                return 1;
            }
            if v1_i < v2_i {
                return -1;
            }
            if v1_i == 0 && v2_i == 0 {
                return 0;
            }
        }
    }
}