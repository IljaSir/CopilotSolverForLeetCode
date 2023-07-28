impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let v1: Vec<&str> = version1.split('.').collect();
        let v2: Vec<&str> = version2.split('.').collect();
        let l1 = v1.len();
        let l2 = v2.len();
        let mut i = 0;
        while i < l1 || i < l2 {
            let n1 = if i < l1 {
                v1[i].parse::<i32>().unwrap()
            } else {
                0
            };
            let n2 = if i < l2 {
                v2[i].parse::<i32>().unwrap()
            } else {
                0
            };
            if n1 > n2 {
                return 1;
            } else if n1 < n2 {
                return -1;
            }
            i += 1;
        }
        0
    }
}