impl Solution {
    pub fn compare_version(version1: String, version2: String) -> i32 {
        

        let mut v1: Vec<i32> = version1.split(".").map(|x| x.parse::<i32>().unwrap()).collect();
        let mut v2: Vec<i32> = version2.split(".").map(|x| x.parse::<i32>().unwrap()).collect();
        while v1.len() > v2.len() {
            v2.push(0);
        }
        while v1.len() < v2.len() {
            v1.push(0);
        }
        for i in 0..v1.len() {
            if v1[i] > v2[i] {
                return 1;
            } else if v1[i] < v2[i] {
                return -1;
            }
        }
        0
    }
}