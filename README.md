# plants_disease_classify_pytorch


**背景**

pytorch 进行图像分类的代码（[从实例掌握 pytorch 进行图像分类](http://spytensor.com/index.php/archives/21/)）

**数据**

<img src="https://pic2.zhimg.com/80/v2-1fa8dc0c244e0992041244101a7422bc_720w.jpg">

<img src="https://s1.ax1x.com/2020/09/24/0pyoJx.jpg">

新增数据集下载链接：[百度网盘]( https://pan.baidu.com/s/19pgCvmKR2beYFfl0DwRFWw  ) 提取码：yae4
包含训练集、验证集、测试集A/B.

**数据增强**

`data_aug.py` 用于线下数据增强，支持的增强方式：

- 高斯噪声
- 亮度变化
- 左右翻转
- 上下翻转
- 色彩抖动
- 对比度变化
- 锐度变化

注：对比度增强在可视化后，主观感觉特征更明显了，如果做了对比度增强，在测试集的时候最好也做一下。


比赛地址（已失效）：[农作物病害检测](https://challenger.ai/competition/pdr2018)

**成绩**：线上 0.8805，线下0.875，由于划分存在随机性，可能复现会出现波动。

## 提醒

`main.py` 中的test函数已经修正，执行后在 `./submit/`中会得到提交格式的 json 文件。依赖中的 pytorch 版本请保持一致，不然可能会有一些小 BUG。

### 1. 依赖

    python3.6 pytorch0.4.1

### 2. 关于数据的处理

首先说明，使用的数据为官方更新后的数据，并做了一个统计分析（下文会给出），最后决定删除第 44 类和第 45 类。
并且由于数据分布的原因，将 train 和 val 数据集合并后，采用随机划分。

数据增强方式：

- RandomRotation(30)
- RandomHorizontalFlip()
- RandomVerticalFlip()
- RandomAffine(45)

图片尺寸选择了320。

### 3. 模型选择

模型目前就尝试了 resnet50。

### 4. 超参数设置

详情在 config.py 中

### 5.使用方法

- 第一步：将测试集图片复制到 `data/test/` 下
- 第二步：将训练集合验证集中的图片都复制到 `data/temp/images/` 下，将两个 `json` 文件放到 `data/temp/labels/` 下
- 执行 move.py 文件
- 执行 main.py 进行训练

### 6.数据分布图

训练集

![train](https://s1.ax1x.com/2020/09/24/0p6nf0.png)

验证集

![validation](https://s1.ax1x.com/2020/09/24/0p6Q6U.png)

### 7. 参考
[Ai Challenger 2018 Competitions 农作物病害检测](https://github.com/spytensor/plants_disease_detection)
