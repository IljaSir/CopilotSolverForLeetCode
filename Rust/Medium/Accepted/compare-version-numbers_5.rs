impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let v1: Vec<&str> = version1.split('.').collect();
        let v2: Vec<&str> = version2.split('.').collect();
        let mut i = 0;
        let mut j = 0;
        while i < v1.len() || j < v2.len() {
            let mut n1 = 0;
            let mut n2 = 0;
            if i < v1.len() {
                n1 = v1[i].parse::<i32>().unwrap();
                i += 1;
            }
            if j < v2.len() {
                n2 = v2[j].parse::<i32>().unwrap();
                j += 1;
            }
            if n1 > n2 {
                return 1;
            }
            if n1 < n2 {
                return -1;
            }
        }
        return 0;
    }
}