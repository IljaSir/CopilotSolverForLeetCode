impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut arr = arr;
        arr.sort();
        for i in (0..4).rev() {
            for j in (0..4).rev() {
                if i == j { continue; }
                for k in (0..4).rev() {
                    if i == k || j == k { continue; }
                    let l = 6 - i - j - k;
                    if arr[i] * 10 + arr[j] < 24 && arr[k] * 10 + arr[l] < 60 {
                        return format!("{:02}:{:02}", arr[i] * 10 + arr[j], arr[k] * 10 + arr[l]);
                    }
                }
            }
        }
        String::new()
    }
}