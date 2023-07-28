impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut arr = arr;
        arr.sort();
        let mut res = String::new();
        for i in (0..arr.len()).rev() {
            for j in (0..i).rev() {
                for k in (0..j).rev() {
                    let h = arr[i] * 10 + arr[j];
                    let m = arr[k] * 10 + arr[k ^ 1];
                    if h < 24 && m < 60 {
                        res.push_str(&format!("{:02}:{:02}", h, m));
                        return res;
                    }
                }
            }
        }
        res
    }
}