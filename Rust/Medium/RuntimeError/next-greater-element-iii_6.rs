impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut arr = n.to_string().into_bytes();
        let mut i = arr.len() - 1;
        while i > 0 && arr[i] <= arr[i - 1] {
            i -= 1;
        }
        if i == 0 {
            return -1;
        }
        let mut j = arr.len() - 1;
        while j >= i && arr[j] <= arr[i - 1] {
            j -= 1;
        }
        arr.swap(i - 1, j);
        let mut l = i;
        let mut r = arr.len() - 1;
        while l < r {
            arr.swap(l, r);
            l += 1;
            r -= 1;
        }
        let s = String::from_utf8(arr).unwrap();
        let res = i32::from_str_radix(&s, 10).unwrap();
        if res > n {
            res
        } else {
            -1
        }
    }
}