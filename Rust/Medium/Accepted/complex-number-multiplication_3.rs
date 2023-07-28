impl Solution {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        

        let nums1: Vec<i32> = num1.split("+").map(|x| x.replace("i", "").parse::<i32>().unwrap()).collect();
        let nums2: Vec<i32> = num2.split("+").map(|x| x.replace("i", "").parse::<i32>().unwrap()).collect();
        let a = nums1[0];
        let b = nums1[1];
        let c = nums2[0];
        let d = nums2[1];
        let real = a * c - b * d;
        let imaginary = a * d + b * c;
        format!("{}+{}i", real, imaginary)
    }
}