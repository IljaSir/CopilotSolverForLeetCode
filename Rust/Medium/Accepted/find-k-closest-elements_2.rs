impl Solution {
    pub fn find_closest_elements(arr: Vec<i32>, k: i32, x: i32) -> Vec<i32> {
        

        let mut arr = arr;
        let mut k = k;
        let mut x = x;
        let mut i = 0;
        let mut j = arr.len() - 1;
        while j - i + 1 > k as usize {
            if (x - arr[i]).abs() <= (x - arr[j]).abs() {
                j -= 1;
            } else {
                i += 1;
            }
        }
        arr[i..=j].to_vec()
    }
}