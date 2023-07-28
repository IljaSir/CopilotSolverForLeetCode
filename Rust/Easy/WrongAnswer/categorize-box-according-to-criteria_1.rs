impl Solution {
    pub fn categorize_box(length: i32, width: i32, height: i32, mass: i32) -> String {
        
        let volume = length * width * height;
        let is_bulky = length >= 10_000 || width >= 10_000 || height >= 10_000 || volume >= 1_000_000_000;
        let is_heavy = mass >= 100;
        if is_bulky && is_heavy {
            "Both".to_string()
        } else if is_bulky {
            "Bulky".to_string()
        } else if is_heavy {
            "Heavy".to_string()
        } else {
            "Neither".to_string()
        }
    }
}