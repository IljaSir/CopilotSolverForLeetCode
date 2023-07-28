impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let v1: Vec<&str> = version1.split('.').collect();
        let v2: Vec<&str> = version2.split('.').collect();
        let mut i = 0;
        while i < v1.len() || i < v2.len() {
            let mut a = 0;
            let mut b = 0;
            if i < v1.len() {
                a = v1[i].parse::<i32>().unwrap();
            }
            if i < v2.len() {
                b = v2[i].parse::<i32>().unwrap();
            }
            if a > b {
                return 1;
            } else if a < b {
                return -1;
            } else {
                i += 1;
            }
        }
        0
    }
}