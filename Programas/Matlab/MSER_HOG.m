
clear all
close all
clc

Area = [100 12000];
ThresholdDelta = 16;

I = ((imread('fotos\34.jpg')));
figure
imshow(I);
Igray = rgb2gray(I);

tic
[regions] = detectMSERFeatures(Igray,'RegionAreaRange',Area,'ThresholdDelta',ThresholdDelta);
toc

figure
imshow(Igray);
hold on;
plot(regions,'showPixelList', true, 'showEllipses', true);
hold off;

%%
for n = 1:regions.Count
    
    regiao = regions(n).PixelList;
    menor = min(regiao(:,:));
    maior = max(regiao(:,:));
    height = maior(1)-menor(1);
    width = maior(2)-menor(2);
    razao = (double(height))/(double(width))
    if(razao>= 0.7 && razao <= 1.3)
        c = imcrop(Igray, [menor(1) menor(2)  height width]);
        d = imresize(c,[150 150]);
        
        tic
        [hog1,visualization] = extractHOGFeatures(d,'CellSize',[3 3]);
        toc
        
        figure
        plot(visualization)
        figure
        imshow(c)
        figure
        imshow(d)

        hog{n,:} = hog1;
    end

end




