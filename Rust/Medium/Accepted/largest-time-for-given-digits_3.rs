impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut arr = arr;
        arr.sort();
        let mut res = String::from("");
        for i in (0..4).rev() {
            for j in (0..4).rev() {
                for k in (0..4).rev() {
                    if i == j || i == k || j == k {
                        continue;
                    }
                    let hour = arr[i] * 10 + arr[j];
                    let min = arr[k] * 10 + arr[6 - i - j - k];
                    if hour < 24 && min < 60 {
                        res = format!("{}{}:{}{}", arr[i], arr[j], arr[k], arr[6 - i - j - k]);
                        return res;
                    }
                }
            }
        }
        res
    }
}