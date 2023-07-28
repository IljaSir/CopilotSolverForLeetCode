impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut arr = [0; 10];
        for c in num.chars() {
            arr[c as usize - 48] += 1;
        }
        let mut i = 9;
        while i > 0 && arr[i] == 0 {
            i -= 1;
        }
        if i == 0 {
            return "".to_string();
        }
        if arr[i] <= 3 {
            return "0".repeat(arr[i]);
        }
        let mut ret = String::new();
        let mut j = 0;
        while j < 3 {
            ret.push((i + 48) as u8 as char);
            j += 1;
        }
        arr[i] -= 3;
        i = 0;
        while i < 10 {
            ret.push_str(&"0".repeat(arr[i]));
            i += 1;
        }
        return ret;
    }
}